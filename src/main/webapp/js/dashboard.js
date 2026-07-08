async function carregarEstoque(){
    try{
        const response = await fetch("http://localhost:8080/dashboard/estoque");
        const dados = await response.json();
        
        const tabela = document.getElementById("corpoTabela");
        tabela.innerHTML = "";
        
        dados.forEach(item =>{
            const linha = document.createElement("tr")
            linha.innerHTML = `
                       <td>${item.codigoBarras}</td>
                       <td>${item.titulo}</td>
                       <td>${item.genero}</td>
                       <td>${item.editora}</td>
                       <td>${item.dataPublicacao}</td>
                       <td>${item.localArmazenamento}</td>
                       <td>${item.quantidade}</td>
                       <td>${item.quantidadeMin}</td>
                       <td>${item.valor}</td>
                         `
            if(item.status == "ACABOU"){
                linha.classList.add('ACABOU')
            }

            if(item.status == "ACABANDO"){
                linha.classList.add('ACABANDO')
            }
 
            tabela.appendChild(linha);
        });
    }catch(erro){
        console.log("Erro ao carregar os produtos", erro);
    }
}

async function carregarResumo(){
    try{
        const response = await fetch("http://localhost:8080/dashboard/resumo");
        const dados = await response.json();
        document.getElementById("cardEntrada").innerHTML = dados.estoque;
        document.getElementById("cardSaida").innerHTML = dados.saida;
        document.getElementById("cardTotal").innerHTML = dados.total;
        
    }catch(erro){
        console.log("Erro na consulta dos dados", erro);
    }
}


//manter sempre carregado
document.addEventListener('DOMContentLoaded', () => {
    carregarEstoque();
    carregarResumo();
});
