class Carro {
    constructor(marca, modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = Date.now(); 
    }
}

let frotaDeCarros = [];

function renderizarFrota() {
    const container = document.getElementById('cards-container');
    container.innerHTML = '';

    frotaDeCarros.forEach(carro => {
        const colDiv = document.createElement('div');
        colDiv.className = 'col-md-4 mb-4';

        colDiv.innerHTML = `
            <div class="card h-100 shadow-sm border-primary">
                <div class="card-header bg-primary text-white">
                    Carro #${carro.id.toString().slice(-4)} <!-- Mostra os últimos 4 dígitos do ID -->
                </div>
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title">${carro.marca}</h5>
                    <p class="card-text fs-4 fw-bold text-secondary">${carro.modelo}</p>
                    
                    <!-- Botão de ação chamando um método do objeto (conceito POO) -->
                    <button class="btn btn-outline-primary mt-auto" onclick="buzinar('${carro.marca}', '${carro.modelo}')">
                        Buzinar
                    </button>
                </div>
            </div>
        `;

        container.appendChild(colDiv);
    });
}

function cadastrarCarro() {
    const marcaInput = document.getElementById('marcaCarro').value;
    const modeloInput = document.getElementById('modeloCarro').value;

    if (marcaInput === '' || modeloInput === '') {
        alert('Por favor, preencha ambos os campos!');
        return;
    }

    const novoCarro = new Carro(marcaInput, modeloInput);

    frotaDeCarros.push(novoCarro);

    document.getElementById('marcaCarro').value = '';
    document.getElementById('modeloCarro').value = '';

    renderizarFrota();
}

function buzinar(marca, modelo) {
    alert(`Beep Beep! O ${marca} ${modelo} está buzinando!`);
}
