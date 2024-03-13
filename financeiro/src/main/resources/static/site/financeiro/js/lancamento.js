

async function insert() {

  const data = {
                   "conta": {
                        "id": document.getElementById("contaId").value
                   },
                   "banco": {
                        "id": document.getElementById("bancoId").value
                   },
                   "ano": document.getElementById("ano").value,
                   "mes": document.getElementById("mes").value,
                   "diaVencimento": document.getElementById("diaVencimento").value,
                   "diaPagamento": document.getElementById("diaPagamento").value,
                   "diaLancemento": document.getElementById("diaLancemento").value,
                   "valorPrevisto": document.getElementById("valorPrevisto").value,
                   "valorRealizado": document.getElementById("valorRealizado").value

               };

  try {
    const response = await fetch("http://localhost:8080/api/financeiro/lancamentos", {
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

  const id = document.getElementById("lancamentoId").value;

  const data = {
                   "conta": {
                        "id": document.getElementById("contaId").value
                   },
                   "banco": {
                        "id": document.getElementById("bancoId").value
                   },
                   "ano": document.getElementById("ano").value,
                   "mes": document.getElementById("mes").value,
                   "diaVencimento": document.getElementById("diaVencimento").value,
                   "diaPagamento": document.getElementById("diaPagamento").value,
                   "diaLancemento": document.getElementById("diaLancemento").value,
                   "valorPrevisto": document.getElementById("valorPrevisto").value,
                   "valorRealizado": document.getElementById("valorRealizado").value

               };

  try {
    const response = await fetch("http://localhost:8080/api/financeiro/lancamentos/"+id, {
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

     fetch('http://localhost:8080/api/financeiro/lancamentos')
     .then(response => response.json())
     .then(data => {
         data.forEach(lancamento => {
             const row = document.createElement('tr');
             row.innerHTML = `<td>${lancamento.id}</td>
                              <td>${lancamento.ano}</td>
                              <td>${lancamento.mes}</td>
                              <td>${lancamento.diaVencimento}</td>
                              <td>${lancamento.diaPagamento}</td>
                              <td>${lancamento.diaLancamento}</td>
                              <td>${lancamento.valorPrevisto}</td>
                              <td>${lancamento.valorRealizado}</td>
                              <td>${lancamento.banco.nome}</td>
                              <td>${lancamento.conta.nome}</td>
                              <td>${lancamento.conta.entradaSaidaSaldo}</td>
                              <td>${lancamento.conta.receitaDespesa}</td>`;
             document.getElementById('tbody').appendChild(row);
         });
     })
     .catch(error => console.error('Erro ao obter lancamentos:', error));
}


async function findAllBanco() {

    const bancosSelect = document.getElementById("bancos");

    fetch('http://localhost:8080/api/financeiro/bancos')
         .then(response => response.json())
         .then(data => {
             data.forEach(banco => {
                 const option = document.createElement('option');
                 option.innerHTML = `<option value=${banco.id}>${banco.nome}</option>`;
                 bancosSelect.appendChild(option);
             });
         })
         .catch(error => console.error('Erro ao obter bancos:', error));

}

async function findAllConta() {

    const contasSelect = document.getElementById("contas");

    fetch('http://localhost:8080/api/financeiro/contas')
         .then(response => response.json())
         .then(data => {
             data.forEach(conta => {
                 const option = document.createElement('option');
                 option.innerHTML = `<option value=${conta.id}>${conta.nome}</option>`;
                 contasSelect.appendChild(option);
             });
         })
         .catch(error => console.error('Erro ao obter bancos:', error));

}

