async function filtroEstoque() {

    try {
        
        const url = `http://localhost:8080/dashboard/estoque?nome=
        ${encodeURIComponent(titulo)}
        &tipo=${encodeURIComponent(genero)}&
            &data=${encodeURIComponent(data)}`;

        const response = await fetch(url);
        const dados = await response.json();

        const titulo = document.getElementById("pesquisarNome").value;
        const genero = document.getElementById("filtroGenero").value;
        const data = document.getElementById("filtroData").value;
        
        const tabela = document.getElementById("corpoTabela");
        tabela.innerHTML = "";

        const filtrados = dados.filter(item => {

            const matchTitulo = titulo === "" || item.titulo.toLowerCase().includes(titulo);
            const matchGenero = genero === "" || item.genero === genero;
            const matchData = data === "" || item.dataPublicacao === data;

            return matchTitulo && matchGenero && matchData;
        });

        filtrados.forEach(item => {
            const linha = `
            <tr>
                <td>${item.codigoBarras}</td>
                <td>${item.nomeProduto}</td>
                <td>${item.fabricante}</td>
                <td>${item.marca}</td>
                <td>${item.quantidade}</td>
                <td>${parseFloat(item.valor).toFixed(2)}</td>
                <td>${parseFloat(item.total).toFixed(2)}</td>
                <td>${item.status}</td>
            </tr>
            `;
            tabela.innerHTML += linha;
        });
    } catch (erro) {
        console.error("Erro ao filtrar", erro);
    }
}

document.getElementById("btnPesquisar").addEventListener("click", filtroEstoque);