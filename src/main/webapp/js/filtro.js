async function filtroEstoque() {
        const titulo = document.getElementById("pesquisarNome").value;
        const genero = document.getElementById("filtroGenero").value;
        const data = document.getElementById("filtroData").value;
    try {
        
        const url = `http://localhost:8080/dashboard/estoque?titulo=${encodeURIComponent(titulo)}&genero=${encodeURIComponent(genero)}&data=${encodeURIComponent(data)}`;

        const response = await fetch(url);
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
    } catch (erro) {
        console.error("Erro ao filtrar", erro);
    }
}

document.getElementById("btnPesquisar").addEventListener("click", filtroEstoque);