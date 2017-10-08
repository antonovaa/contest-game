booK.controller('QuestionControll', function($scope, $http, productService) {
  productService.addProduct("currObj");
  $scope.loaded = false;
  $scope.teste=5;
  $scope.bolo=true;
  $scope.load1= function () {
    $http({
      method: 'GET',
      url: 'question.json'
    }).then(function successCallback(response) {
      // this callback will be called asynchronously
      // when the response is available
      $scope.question = response.data.question;
      $scope.loaded = true;
    }, function errorCallback(response) {
      // called asynchronously if an error occurs
      // or server returns response with an error status.
      $scope.error = response.statusText;
    });
  };
  $scope.voteUp = function (answer) {
    answer.rate++;
  };
  $scope.voteDown = function (answer) {
    answer.rate--;
  };
});