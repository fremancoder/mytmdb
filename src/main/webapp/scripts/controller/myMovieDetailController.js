(function (){
	
	var app = angular.module("tmdbViewer");
	
	var MyMovieDetailController = function($scope, $http, $log, $routeParams) {
		
		var onMovieGet = function(response){
			$scope.movieDetails = response.data; 
		}; 
		
		var onError = function(reason){
			$scope.error = "Could not fetch the data."; 
		}; 


		var getMovie = function(){
			$http.get("http://localhost:8080/mytmdb/webapi/movies/" + $routeParams.movieid )
				.then(onMovieGet, onError);
		};
		
		getMovie();

	}
	
	app.controller("MyMovieDetailController", ["$scope", "$http", "$log", "$routeParams", MyMovieDetailController]);
	
}());
