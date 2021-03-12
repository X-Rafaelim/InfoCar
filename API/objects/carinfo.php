<?php

class info{
	private $conn;
	private $table_name = "infos";

	public $models_idmodels;
	public $production_years;
	public $engine_code;
	public $fuel_type;
	public $aspiration;
	public $traction;
	public $gearbox;
	public $hp;
	public $top_speed;
	public $max_rpm;
	public $fuel_tank_capacity;
	public $weight;
	public $num_doors;
	public $fuel_consumption;
	public $image;

	public function __construct($db){
		$this->conn = $db;
	}

	function read_(){
	$query = "SELECT * FROM carinfo";

	//prepare query statement
	$stmt = $this->conn->prepare($query);

	//execute query
	$stmt->execute();

	return $stmt;
}

}



?>