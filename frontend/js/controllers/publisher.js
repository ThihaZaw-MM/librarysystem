angular
.module('app')
.controller('PublisherController',
	['$scope', '$stateParams', '$http', '$location','urls', 
	function($scope, $stateParams, $http, $location, urls) {
		var self = this;
    	self.publisher = {};
    	self.publishers = [];
    	self.submit = submit;
		self.deletePublisher = deletePublisher;
    	self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

    	console.log("Fetching publishers");

		if($stateParams.publisher != null){
            console.log($stateParams.publisher);
            self.publisher = $stateParams.publisher;
        }

		$http.get(urls.USER_SERVICE_API + "publishers")
			.then(
				function (response) {
					self.publishers = response.data;
				},
				function (errResponse) {
		            console.error('Error while loading publishers');
		        }
			);

		function submit() {
			if (self.publisher.id === undefined || self.publisher.id === null) {
                console.log('Saving New publisher', self.publisher);
                createPublisher(self.publisher);
            } else {
                console.log('publisher updated with id ', self.publisher.id);
				updatePublisher(self.publisher);
            }
		}

		function updatePublisher(publisher) {
			$http.put(urls.USER_SERVICE_API + "publishers/" + publisher.id, publisher)
				.then(
					function (response) {
						console.log('Save success for new publisher');
			        	$location.path('/publishers');
					}, 
					function (errResponse) {
						console.error('Error while saving new publisher');
			            console.error(errResponse);
					}
				);
		}

		function createPublisher(publisher) {
            console.log('About to create publisher');
			publisher.id = "2d856332-d21f-4732-9787-1c2ddf21e0a0";
			$http.post(urls.USER_SERVICE_API + "publishers", publisher)
			    .then(
			        function (response) {
			        	console.log('Save success for new publisher');
			        	//console.log($location)
			        	$location.path('/publishers');
			        },
			        function (errResponse) {
			            console.error('Error while saving new publisher');
			            console.error(errResponse);
			        }
			  );
        }

		function deletePublisher(id) {
			console.log('Deleting publisher' + id);
			$http.delete(urls.USER_SERVICE_API + "publishers/" + id)
				.then(
					function (response) {
						console.log('Delete success for publisher');
			        	var index = -1;		
						var tsArr = eval( self.publishers );
						for( var i = 0; i < tsArr.length; i++ ) {
							if( tsArr[i].id === id ) {
								index = i;
								break;
							}
						}
						
						if(index >= 0) {
							self.publishers.splice( index, 1 );
						}
					}, 
					function (errResponse) {
						console.error('Error while deleting publisher');
			            console.error(errResponse);
					}
				);
		}
	}
]);