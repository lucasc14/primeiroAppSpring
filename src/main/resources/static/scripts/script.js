document.addEventListener("DOMContentLoaded", () => {

    const forms = document.querySelectorAll("form");

    forms.forEach(form => {

        form.addEventListener("submit", (event) => {

            event.preventDefault();

            const botao = form.querySelector("button");

            const textoOriginal = botao.innerText;

            botao.innerText = "Processando...";
            botao.disabled = true;

            setTimeout(() => {

                botao.innerText = "✓ Sucesso";

                setTimeout(() => {
                    botao.innerText = textoOriginal;
                    botao.disabled = false;
                }, 1500);

            }, 1000);

        });

    });

}); 