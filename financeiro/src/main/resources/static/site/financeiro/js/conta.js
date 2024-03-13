

async function insert() {

  const data = {
                   "nome": document.getElementById("nome").value,
                   "entradaSaidaSaldo": document.getElementById("entradaSaidaSaldo").value,
                   "receitaDespesa": document.getElementById("receitaDespesa").value
               };

  try {
    const response = await fetch("http://localhost:8080/api/financeiro/contas", {
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

  const id = document.getElementById("contaId").value;

  const data = {
                   "nome": document.getElementById("nome").value,
                   "entradaSaidaSaldo": document.getElementById("entradaSaidaSaldo").value,
                   "receitaDespesa": document.getElementById("receitaDespesa").value
               };

  try {
    const response = await fetch("http://localhost:8080/api/financeiro/contas/"+id, {
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

     fetch('http://localhost:8080/api/financeiro/contas')
     .then(response => response.json())
     .then(data => {
         data.forEach(conta => {
             const row = document.createElement('tr');
             row.innerHTML = `<td>${conta.id}</td><td>${conta.nome}</td><td>${conta.entradaSaidaSaldo}</td><td>${conta.receitaDespesa}</td>`;
             document.getElementById('tbody').appendChild(row);
         });
     })
     .catch(error => console.error('Erro ao obter contas:', error));
}




