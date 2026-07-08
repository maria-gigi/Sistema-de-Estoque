let livroSelecionado = null;

document.addEventListener('DOMContentLoaded', async function () {
    const resp = await fetch(`http://localhost:8080/livro`);
    const dados = await resp.json();

    const titulo = document.getElementById("titulo");
    const tituloSugestao = document.getElementById("tituloSugestao");
    const Quantidade = document.getElementById("quantidade");
    const Desconto = document.getElementById("desconto");

    Quantidade.addEventListener("input", calcular);
    Desconto.addEventListener("input", calcular);

    titulo.addEventListener("input", (e) => autoCompletar(e, dados, titulo, tituloSugestao));
    
    titulo.addEventListener("keydown", (e) => {
        if (tituloSugestao.value) {
            if (e.key === " " || e.key === "Tab") { 
                e.preventDefault();
                titulo.value = tituloSugestao.value; 
                tituloSugestao.value = ""; 

                
                livroSelecionado = dados.find(livro => livro.titulo.toLowerCase() === titulo.value.toLowerCase());
                document.getElementById("codigoBarras").value = livroSelecionado.codigoBarras;
                document.getElementById("editora").value = livroSelecionado.editora;
                document.getElementById("dataPublicacao").value = livroSelecionado.dataPublicacao;
                calcular(); 
            }
        }
    });

    titulo.addEventListener("blur", () => {
        setTimeout(() => { tituloSugestao.value = ""; }, 200);
    });
});

function autoCompletar(e, dados, titulo, tituloSugestao) {
    const valorDigitado = e.target.value;
    
    if (!valorDigitado || valorDigitado.trim() === "") {
        tituloSugestao.value = "";
        livroSelecionado = null;
        return;
    }

    const correspondencia = dados.find(livro => 
        livro.titulo.trim().toLowerCase().startsWith(valorDigitado.toLowerCase())
    );

    if (correspondencia) {
        tituloSugestao.value = valorDigitado + correspondencia.titulo.slice(valorDigitado.length);
    } else {
        tituloSugestao.value = "";
        livroSelecionado = null;
    }
}

function calcular() {
    if (!livroSelecionado) return;

    let quantidade = parseInt(document.getElementById("quantidade").value) || 0;
    let desconto = parseFloat(document.getElementById("desconto").value) || 0;
    
    let valorUnitario = parseFloat(livroSelecionado.valor) || 0;
    let total = (valorUnitario * quantidade) - desconto;

    if (total < 0) total = 0;

    document.getElementById("total").value = total.toFixed(2); 
}