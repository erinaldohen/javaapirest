const formulario = document.getElementById("formularioDeCadastroCliente");

formulario.addEventListener("submit", function(event) {
    evento.preventDefault(); // Evita a submissão do formulário padrão
    
    /*O FormData é uma interface fornecida pelo JavaScript que permite a criação
    * e manipulação de objetos que representam dados de formulários HTML. Com o FormData, 
    * é possível coletar os valores dos campos de um formulário e enviá-los para o servidor
    * de forma fácil e eficiente. */
    const dadosDoFormulario = new FormData(formulario);
    // O método 'Object.fromEntries' transforma uma lista de pares chave-valor em um objeto.
    const dadosConvertidosEmObjeto = Object.fromEntries(dadosDoFormulario) 

    fetch("/aluno", {
        method: "POST",
        body: dadosDoFormulario,
        body: JSON.stringify(dadosConvertidosEmObjeto)
    })
        .then(response => response.json())
        .then(data => {
            console.log(data))
        })
        .catch(error => {
                  console.error(error);
                });
    });