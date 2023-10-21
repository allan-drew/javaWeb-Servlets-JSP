
function confirmarExclusao(id) {
    let resposta = confirm("Tem certeza que deseja excluir?")

    if (resposta == true) {
        //alert(id)

        //encaminhando para o servlet
        window.location.href = "controller?action=removecliente&id=" + id
    }

}