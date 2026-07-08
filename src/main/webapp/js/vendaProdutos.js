document.addEventListener('DOMContentLoaded', async function () {
    const resp = await fetch(`http://localhost:8080/livro`);
    const dados = await resp.json();

    const titulo = document.getElementById("titulo");
    const tituloSugestao = document.getElementById("tituloSugestao");

    titulo.addEventListener("input", (e) => autoCompletar(e, dados, titulo, tituloSugestao));
    
    titulo.addEventListener("keydown", (e) => {
        if (tituloSugestao.value) {
            if (e.key === " " || e.key === "Tab") { 
                e.preventDefault();
                titulo.value = tituloSugestao.value; 
                tituloSugestao.value = ""; 
            }
        }
    });

    titulo.addEventListener("blur", () => {
        tituloSugestao.value = "";
    });
});

function autoCompletar(e, dados, titulo, tituloSugestao) {
    const valorDigitado = e.target.value;
    
    if (!valorDigitado) {
        tituloSugestao.value = "";
        return;
    }

    const correspondencia = dados.find(livro => 
        livro.toLowerCase().startsWith(valorDigitado.toLowerCase())
    );

    if (correspondencia) {
        tituloSugestao.value = valorDigitado + correspondencia.slice(valorDigitado.length);
    } else {
        tituloSugestao.value = "";
    }
}

document.getElementById("lblTotalGeral").addEventListener("input", calcular);
document.getElementById("quantidade").addEventListener("input", calcular);

function calcular(){
    let valor = parseFloat(document.getElementById("valor").value) || 0;
    let quantidade = parseInt(document.getElementById("quantidade").value) || 0;
    
    document.getElementById("total").value = (valor * quantidade).toFixed(2); 
}
