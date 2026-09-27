class Carro {
    constructor(marca, modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = Date.now(); 
    }
}

let carro1 = new Carro('Toyota', 'Corolla');
let carro2 = new Carro();
carro2.marca = 'Honda';
carro2.modelo = 'Civic';

console.log(carro1);
console.log(carro2);
function buzinar(marca, modelo) {
    console.log(`Beep Beep! O ${marca} ${modelo} está buzinando!`);
}
