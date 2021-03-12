<?php


class brands{
	private $conn;
	private $table_name = "brands";

	public $idbrands;
	public $brand_name;
	public $image;


	public function __construct($db){
		$this->conn = $db;
	}

	function read_brand(){
		$query_brand = "SELECT * FROM brands";

		////prepare query statement 
		$stmt = $this->conn->prepare($query_brand);

		//execute query 
		$stmt->execute();

		return $stmt;
	}
}

?>