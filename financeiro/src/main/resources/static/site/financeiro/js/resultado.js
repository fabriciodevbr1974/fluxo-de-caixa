async function findAllResultado() {
     document.getElementById('tbodyResultado').innerHTML = '';

     fetch('http://localhost:8080/api/financeiro/resultados/saldo?ano=2024&mes=1')
     .then(response => response.json())
     .then(data => {
             const row = document.createElement('tr');
             row.innerHTML = `<td>${data.valorPrevisto}</td>
                              <td>${data.valorRealizado}</td>`;
             document.getElementById('tbodyResultado').appendChild(row);
     })
     .catch(error => console.error('Erro ao obter resultados:', error));
}


