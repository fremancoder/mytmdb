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
			$http.get("http://84.196.249.71:8080/mytmdb/webapi/movies/" + $routeParams.movieid )
				.then(onMovieGet, onError);
		};
		
		var onMovieUpdate = function(response){
			$scope.movieDetails = response.data; 
		}; 

		$scope.toggleSeen = function(movieId){
			$http.put("http://84.196.249.71:8080/mytmdb/webapi/movies/" + movieId + "/seen")
				.then(onMovieUpdate, onError);
		};
		
		$scope.toggleSubtitle = function(movieId){
			$http.put("http://84.196.249.71:8080/mytmdb/webapi/movies/" + movieId + "/subtitle")
				.then(onMovieUpdate, onError);
		};		
		
		getMovie();

	}
	
	app.controller("MyMovieDetailController", ["$scope", "$http", "$log", "$routeParams", MyMovieDetailController]);
	
}());
