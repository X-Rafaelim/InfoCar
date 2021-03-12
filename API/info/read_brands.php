<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

//database connection 
include_once '../config/database.php';
include_once '../objects/brands.php';

//instanciar database and product object
$database = new Database();
$db = $database->getConnection();

//initialize object
$brand = new brands($db);

//read brands
$stmt = $brand->read_brand();
$num = $stmt->rowCount();


//check if more than 0 record found 
if ($num>0) {

	//brand array
	$brand_arr = array();
	$brand_arr["records"]=array();
	

	while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
		extract($row);

		$brand_info=array(
			"idbrands" => $idbrands,
			"brand_name" => $brand_name,
			"image" => $image
		);

		array_push($brand_arr["records"], $brand_info);
	}
	//set response code -200 ok
	http_response_code(200);

	//show info in jsoin format
	echo json_encode($brand_arr);
}

else{
  
    // set response code - 404 Not found
    http_response_code(404);
  
    // tell the user no products found
    echo json_encode(
        array("message" => "Nada encontrado")
    );
}




?>