<?php


class models{
	private $conn;
	private $table_name = "models";

	public $idmodels;
	public $brands_idbrands;
	public $models;
	public $image;


	public function __construct($db){
		$this->conn = $db;
	}



	function read_model(){
		$query_models = "SELECT * FROM models";

		////prepare query statement 
		$stmt = $this->conn->prepare($query_models);

		//execute query 
		$stmt->execute();

		return $stmt;
	}
}

?>