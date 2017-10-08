/**
 * Created by Lord on 28.09.2017.
 */
// 'use strict';
booK.controller('Bool',function ($scope, productService) {
    $scope.xs=[{"d":1},{"d":3},{"d":5},{"d":38}];
    $scope.products = productService.getProducts();
  $scope.funk=function() {
    $('#for_load2').load('index.html');
  }
});
// $('div').innerHTML('<h1>asdasd</h1>');