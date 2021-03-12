<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

//database connection
include_once '../config/database.php';
include_once '../objects/models.php';


//instanciar database and product object
$database = new Database();
$db = $database->getConnection();

//iniciar objeto
$model = new models($db);

//read models
$stmt = $model->read_model();
$num = $stmt->rowCount();


//check if more than 0 record found 

if ($num>0) {

	//brand array
	$model_arr = array();
	$model_arr["records"]=array();
	

	while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
		extract($row);

		$model_info=array(
			"idmodels" => $idmodels,
			"brands_idbrands" => $brands_idbrands,
			"models" => $models,
			"image" => $image
		);

		array_push($model_arr["records"], $model_info);
	}
	//set response code -200 ok
	http_response_code(200);

	//show info in jsoin format
	echo json_encode($model_arr);
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