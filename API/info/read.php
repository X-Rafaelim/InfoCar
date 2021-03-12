<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

//database connection
include_once '../config/database.php';
include_once '../objects/carinfo.php';

//instantiate database and product object
$database = new Database();
$db = $database->getConnection();

//initialize object
$carinfo = new info($db);


//read products
$stmt = $carinfo->read_();
$num = $stmt->rowCount();

//check if more than 0 record found 
if ($num>0) {

	//carinfo array
	$carinfo_arr = array();
	$carinfo_arr["information"]=array();
	

	while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
		extract($row);

		$carinfo_info=array(
			"models_idmodels" => $models_idmodels,
			"production_years" => $production_years,
			"engine_code" => $engine_code,
			"fuel_type" => $fuel_type,
			"aspiration" => $aspiration,
			"traction" => $traction,
			"gearbox" => $gearbox,
			"hp" => $hp,
			"top_speed" => $top_speed,
			"max_rpm" => $max_rpm,
			"fuel_tank_capacity" => $fuel_tank_capacity,
			"weight" => $weight,
			"num_doors" => $num_doors,
			"fuel_consumption" => $fuel_consumption,
			"image" => $image
		);

		array_push($carinfo_arr["information"], $carinfo_info);
	}
	//set response code -200 ok
	http_response_code(200);

	//show info in jsoin format
	echo json_encode($carinfo_arr);
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