//Criacao modulo principal
var appCliente = angular.module("appCliente", []);

//Controllers de views

appCliente.controller("indexController", function($scope, $http) {
	
	$scope.clients = [];
	$scope.cliente = {};
	
	//BuscarCliente
	$scope.carregarClientes =  function(){
		
	$http({method:'GET', url:'http://localhost:8080/clientes', data: '',
	    headers: {
	        "Content-Type": "application/json"
	    }})
	.then(function (response){
		$scope.clientes = response.data;
		console.log(response.data);
		console.log(response.status);
		
	}, function(response){
		
		console.log(response.data);
		console.log(response.status);
		
	});
	
	
	};
	
	
	//Salvar Cliente
	$scope.salvarCliente = function() {
		
		
		$http({method:'POST', url:'http://localhost:8080/clientes', data: $scope.cliente,
		    headers: {
		        "Content-Type": "application/json"
		    }})
		.then(function (response){
			$scope.clientes.push(response.data);
			
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});
		
	};
	
	
	
	//Excluir Cliente
	$scope.excluirCliente = function(cliente) {
		
		
		$http({method:'DELETE', url:'http://localhost:8080/clientes/' + cliente.id, data:'',
		    headers: {
		        "Content-Type": "application/json"
		    }})
		.then(function (response){
			$scope.carregarClientes();
			
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});
		
	};
	
	
	$scope.carregarClientes();
	
});
