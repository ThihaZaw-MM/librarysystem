//newbook.js
angular
.module('app')
.controller('BookController',
    ['$scope', '$stateParams', '$http', '$location','urls', 
    function($scope, $stateParams, $http, $location, urls) {
    	var self = this;
    	self.book = {};
        self.books = [];
    	self.authorList = {};
        self.publisherList = {};
        self.languageList = {};
    	self.bookTypeList = {};
        self.locationList = {};
        
    	self.submit = submit;
        self.deleteBook = deleteBook;
    	self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        
  		console.log('Loading books in bookController');

        if($stateParams.book != null){
            console.log($stateParams.book);
            self.book = $stateParams.book;
        }

		$http.get(urls.USER_SERVICE_API + "books")
		    .then(
		        function (response) {
		            console.log('Fetched successfully all books');
		            self.books = response.data;
		        },
		        function (errResponse) {
		            console.error('Error while loading books');
		        }
			);

		$http.get(urls.USER_SERVICE_API + "booktypes")
            .then(
                function (response) {
                    console.log('Fetched successfully types');
                    self.bookTypeList = response.data;
                    var allType = {id: 0, bookType: ''};
                },
                function (errResponse) {
                    console.error('Error while loading bookTypes');
                }
            );

        $http.get(urls.USER_SERVICE_API + "authors")
            .then(
                function(response){
                    console.log('Fetched successfully authors');
                    self.authorList = response.data;
                },
                function(errResponse){
                    console.error('Error while loading authors');
                }
            );

        $http.get(urls.USER_SERVICE_API + "publishers")
            .then(
                function(response){
                    console.log('Fetched successfully publishers');
                    self.publisherList = response.data;
                },
                function(errResponse){
                    console.error('Error while loading publishers');
                }
            );
        
        $http.get(urls.USER_SERVICE_API + "languages")
            .then(
                function(response){
                    console.log('Fetched successfully languages');
                    self.languageList = response.data;
                },
                function(errResponse){
                    console.error('Error while loading languages');
                }
            );

            $http.get(urls.USER_SERVICE_API + "locations")
            .then(
                function(response){
                    console.log('Fetched successfully locations');
                    self.locationList = response.data;
                },
                function(errResponse){
                    console.error('Error while loading locations');
                }
            );

        function submit() {
            console.log('Submitting');
            if (self.book.id === undefined || self.book.id === null) {
                console.log('Saving New book', self.book);
                createBook(self.book);
            } else {
                updateBook(self.book, self.book.id);
                console.log('book updated with id ', self.book.id);
            }
        }

        function updateBook(book, id){
            book.patientRegisters = null;
            $http.put(urls.USER_SERVICE_API + "books/" + id, book)
                .then(
                    function(response){
                        console.log('Save success for edit book');
			        	$location.path('/books');
                    },
                    function(errResponse){
                        console.error('Error while saving edit book');
			            console.error(errResponse);
                    }
                );
        }

        function createBook(book) {
            console.log('About to create book');
            console.log(book);
			book.id = "2d856332-d21f-4732-9787-1c2ddf21e0a0";
            book.photo = "";
			$http.post(urls.USER_SERVICE_API + "books", book)
			    .then(
			        function (response) {
			        	console.log('Save success for new book');
			        	$location.path('/books');
			        },
			        function (errResponse) {
			            console.error('Error while saving new book');
			            console.error(errResponse);
			        }
			  );
        }

        function deleteBook(id) {
			console.log('Deleting book' + id);
			$http.delete(urls.USER_SERVICE_API + "books/" + id)
				.then(
					function (response) {
						console.log('Delete success for book');
			        	var index = -1;		
						var bookArr = eval( self.books );
						for( var i = 0; i < bookArr.length; i++ ) {
							if( bookArr[i].id === id ) {
								index = i;
								break;
							}
						}
						
						if(index >= 0) {
							self.books.splice( index, 1 );
						}
					}, 
					function (errResponse) {
						console.error('Error while deleting book');
			            console.error(errResponse);
					}
				);
		}
    }
]);