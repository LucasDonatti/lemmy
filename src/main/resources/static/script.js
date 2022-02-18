function postAoClicar() {

	let nome = document.querySelector('#nome').value
	let alcance = document.querySelector('#alcance').value
	let duracao = document.querySelector('#duracao').value
	let tempoDeConjuracao = document.querySelector('#tempoDeConjuracao').value
	let nivel = document.querySelector('#nivel').value
	let escola = document.querySelector('#escola').value
	let classes = []
	let buscarClasses = document.querySelectorAll('input[name="classes"]:checked')
	for (let i = 0; i < buscarClasses.length; i++) {
		classes[i] = buscarClasses[i].value
	}
	let componentes = []
	let buscarComponentes = document.querySelectorAll('input[name="componentes"]:checked')
	for (let i = 0; i < buscarComponentes.length; i++) {
		componentes[i] = buscarComponentes[i].value
	}
	let material = document.querySelector('#material').value
	let ritual = document.querySelector('input[name="ritual"]:checked').value
	let concentracao = document.querySelector('input[name="concentracao"]:checked').value
	let descricao = document.querySelector('#descricao').value.split('\n')
	let niveisAcima = document.querySelector('#niveisAcima').value.split('\n')

	console.log('             nome: ' + nome)
	console.log('          alcance: ' + alcance)
	console.log('          duracao: ' + duracao)
	console.log('tempoDeConjuracao: ' + tempoDeConjuracao)
	console.log('            nivel: ' + nivel)
	console.log('           escola: ' + escola)
	for (let i = 0; i < classes.length; i++) {
		console.log('        classe[' + i + ']: ' + classes[i])
	}
	for (let i = 0; i < componentes.length; i++) {
		console.log('    componente[' + i + ']: ' + componentes[i])
	}
	console.log('         material: ' + material)
	console.log('           ritual: ' + ritual)
	console.log('     concentracao: ' + concentracao)
	for (let i = 0; i < descricao.length; i++) {
		console.log('     descricao[' + i + ']: ' + descricao[i])
	}
	for (let i = 0; i < niveisAcima.length; i++) {
		console.log('   niveisAcima[' + i + ']: ' + niveisAcima[i])
	}

	axios.post('http://localhost:3035/api/magias', {
		nome: nome,
		descricao: descricao,
		niveisAcima: niveisAcima,
		alcance: alcance,
		componentes: componentes,
		material: material,
		ritual: ritual,
		duracao: duracao,
		concentracao: concentracao,
		tempoDeConjuracao: tempoDeConjuracao,
		nivel: nivel,
		escola: escola,
		classes: classes
	}).then(response => {console.log(response.data)})
		.catch(erro => {console.log(erro)})
	
	alert("Magia adicionada.")
}