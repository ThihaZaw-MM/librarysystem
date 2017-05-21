angular
.module('app')
.controller('BookTypeController',
	['$scope', '$stateParams', '$http', '$location','urls', 
	function($scope, $stateParams, $http, $location, urls) {
		var self = this;
    	self.bookType = {};
    	self.bookTypes = [];
    	self.submit = submit;
		self.deleteBookType = deleteBookType;
    	self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

		console.log("Fetching bookTypes");

		if($stateParams.booktype != null){
            console.log($stateParams.booktype);
            self.bookType = $stateParams.booktype;
        }

		$http.get(urls.USER_SERVICE_API + "booktypes")
			.then(
				function (response) {
					self.bookTypes = response.data;
				},
				function (errResponse) {
		            console.error('Error while loading booktypes');
		        }
			);

		function submit() {
			if (self.bookType.id === undefined || self.bookType.id === null) {
                console.log('Saving New Township', self.bookType);
                createBookType(self.bookType);
            } else {
                console.log('bookType updated with id ', self.bookType.id);
				updateBookType(self.bookType);
            }
		}

		function updateBookType(bookType) {
			$http.put(urls.USER_SERVICE_API + "booktypes/" + bookType.id, bookType)
				.then(
					function (response) {
						console.log('Save success for new BookType');
			        	$location.path('/bookTypes');
					}, 
					function (errResponse) {
						console.error('Error while saving new BookType');
			            console.error(errResponse);
					}
				);
		}

		function createBookType(bookType) {
            console.log('About to create BookType');
			bookType.id = "2d856332-d21f-4732-9787-1c2ddf21e0a0";
			$http.post(urls.USER_SERVICE_API + "booktypes", bookType)
			    .then(
			        function (response) {
			        	console.log('Save success for new BookType');
			        	//console.log($location)
			        	$location.path('/bookTypes');
			        },
			        function (errResponse) {
			            console.error('Error while saving new BookType');
			            console.error(errResponse);
			        }
			  );
        }

		function deleteBookType(id) {
			console.log('Deleting bookType' + id);
			$http.delete(urls.USER_SERVICE_API + "booktypes/" + id)
				.then(
					function (response) {
						console.log('Delete success for BookType');
			        	var index = -1;		
						var bookTypeArr = eval( self.bookTypes );
						for( var i = 0; i < bookTypeArr.length; i++ ) {
							if( bookTypeArr[i].id === id ) {
								index = i;
								break;
							}
						}
						
						if(index >= 0) {
							self.bookTypes.splice( index, 1 );
						}
					}, 
					function (errResponse) {
						console.error('Error while deleting bookType');
			            console.error(errResponse);
					}
				);
		}
	}
]);