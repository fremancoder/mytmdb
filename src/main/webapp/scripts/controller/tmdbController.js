var TmdbController = function($scope, $http) {
	
	var onMovieComplete = function(response){
		$scope.movies = response.data; 
	} 
	
	
	$http.get("http://localhost:8080/mytmdb/webapi/search/tmdbmovies?title=matrix&page=1").then(onMovieComplete);
	
}