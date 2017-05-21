angular
.module('app')
.controller('AuthorController',
	['$scope', '$stateParams', '$http', '$location','urls', 
	function($scope, $stateParams, $http, $location, urls) {
		var self = this;
    	self.author = {};
    	self.authors = [];
    	self.submit = submit;
		self.deleteAuthor = deleteAuthor;
    	self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

		console.log("Fetching authors");

		if($stateParams.author != null){
            console.log($stateParams.author);
            self.author = $stateParams.author;
        }

		$http.get(urls.USER_SERVICE_API + "authors")
			.then(
				function (response) {
					self.authors = response.data;
				},
				function (errResponse) {
		            console.error('Error while loading authors');
		        }
			);

		function submit() {
			if (self.author.id === undefined || self.author.id === null) {
                console.log('Saving New Township', self.author);
                createAuthor(self.author);
            } else {
                console.log('author updated with id ', self.author.id);
				updateAuthor(self.author);
            }
		}

		function updateAuthor(author) {
			$http.put(urls.USER_SERVICE_API + "authors/" + author.id, author)
				.then(
					function (response) {
						console.log('Save success for new author');
			        	$location.path('/authors');
					}, 
					function (errResponse) {
						console.error('Error while saving new author');
			            console.error(errResponse);
					}
				);
		}

		function createAuthor(author) {
            console.log('About to create author');
			author.id = "2d856332-d21f-4732-9787-1c2ddf21e0a0";
			$http.post(urls.USER_SERVICE_API + "authors", author)
			    .then(
			        function (response) {
			        	console.log('Save success for new author');
			        	//console.log($location)
			        	$location.path('/authors');
			        },
			        function (errResponse) {
			            console.error('Error while saving new author');
			            console.error(errResponse);
			        }
			  );
        }

		function deleteAuthor(id) {
			console.log('Deleting author' + id);
			$http.delete(urls.USER_SERVICE_API + "authors/" + id)
				.then(
					function (response) {
						console.log('Delete success for author');
			        	var index = -1;		
						var authorArr = eval( self.authors );
						for( var i = 0; i < authorArr.length; i++ ) {
							if( authorArr[i].id === id ) {
								index = i;
								break;
							}
						}
						
						if(index >= 0) {
							self.authors.splice( index, 1 );
						}
					}, 
					function (errResponse) {
						console.error('Error while deleting author');
			            console.error(errResponse);
					}
				);
		}
	}
]);