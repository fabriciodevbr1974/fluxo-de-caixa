function health() {
    fetch("http://localhost:8080/api/financeiro/bancos/health")
    .then((res) => res.json())
    .then((data) => console.log(data));
}

async function insert() {

  const data = {
                   "nome": document.getElementById("nome").value,
                   "agencia": document.getElementById("agencia").value,
                   "numeroConta": document.getElementById("numeroConta").value,
                   "chavePix": document.getElementById("chavePix").value
               };

  try {
    const response = await fetch("http://localhost:8080/api/financeiro/bancos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    const result = await response.json();
    console.log("Success:", result);
  } catch (error) {
    console.error("Error:", error);
  }
}



async function update() {

  const id = document.getElementById("bancoId").value;

  const data = {
                   "nome": document.getElementById("nome").value,
                   "agencia": document.getElementById("agencia").value,
                   "numeroConta": document.getElementById("numeroConta").value,
                   "chavePix": document.getElementById("chavePix").value
               };

  try {
    const response = await fetch("http://localhost:8080/api/financeiro/bancos/"+id, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    const result = await response.json();
    console.log("Success:", result);
  } catch (error) {
    console.error("Error:", error);
  }
}

async function findAll() {
     document.getElementById('tbody').innerHTML = '';

     fetch('http://localhost:8080/api/financeiro/bancos')
     .then(response => response.json())
     .then(data => {
         data.forEach(banco => {
             const row = document.createElement('tr');
             row.innerHTML = `<td>${banco.id}</td>
                              <td>${banco.nome}</td>
                              <td>${banco.agencia}</td>
                              <td>${banco.numeroConta}</td>
                              <td>${banco.chavePix}</td>
                              <td><a href="banco-update.html?id=${banco.id}">Editar</a></td>`;
             document.getElementById('tbody').appendChild(row);
         });
     })
     .catch(error => console.error('Erro ao obter bancos:', error));
}

async function findById() {

     const id = document.getElementById('bancoId').value;

     var erro = false;

     if(id.trim() === ''){
        window.alert('Informe o id do banco');
        erro = true;
     }

     if(!erro){

          document.getElementById('tbody').innerHTML = '';

          fetch('http://localhost:8080/api/financeiro/bancos/'+id)
          .then(response => response.json())
          .then(data => {
                  const row = document.createElement('tr');
                  row.innerHTML = `<td>${data.id}</td>
                                   <td>${data.nome}</td>
                                   <td>${data.agencia}</td>
                                   <td>${data.numeroConta}</td>
                                   <td>${data.chavePix}</td>
                                   <td><a href="banco-update.html?id=${id}">Editar</a></td>`;
                  document.getElementById('tbody').appendChild(row);
          })
          .catch(error => console.error('Erro ao obter bancos:', error));
     }

}



async function carregarCamposParaEdicao(id) {
    fetch('http://localhost:8080/api/financeiro/bancos/'+id)
    .then(response => response.json())
    .then(data => {
          document.getElementById('bancoId').value = data.id;
          document.getElementById('nome').value = data.nome;
          document.getElementById('agencia').value = data.agencia;
          document.getElementById('numeroConta').value = data.numeroConta;
          document.getElementById('chavePix').value = data.chavePix;
    })
    .catch(error => console.error('Erro ao obter bancos:', error));
}


async function excluir() {

     const id = document.getElementById('bancoId').value;

     var erro = false;

     if(id.trim() === ''){
        window.alert('Informe o id do banco');
        erro = true;
     }

     if(!erro){
        const response = await fetch("http://localhost:8080/api/financeiro/bancos/"+id, {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json",
          }
        });
     }

}
