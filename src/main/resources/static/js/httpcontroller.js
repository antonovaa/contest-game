booK.controller("Ctrl",function ($scope, $http) {
    $scope.loaded=false;
    $scope.b=[];
    $scope.load = function (){
        $scope.b.push('Привет!!');
        $http({method: 'GET', url: 'question.json'}).
        then(function success(response) {
            $scope.question=response.data.question;
            $scope.loaded=true;
        });
    };
    $scope.voteUp = function (answer){
        answer.rate++;
    };
    $scope.voteDown = function (answer){
        answer.rate--;
    };
    $scope.a=function () {
        $scope.c="Привет!!"+$scope.b;
    };

    $scope.sea=function () {
        $http(
            {
                method: 'POST',
                url: '/sea',
                data: JSON.stringify({x:15,y:22,str:"s12333ss"}),
                headers: {'Content-Type': 'application/json'}
            }
        ).
        then(function success(response) {
            $scope.question2=response.data;
            $scope.loaded=true;
        });
    }
});