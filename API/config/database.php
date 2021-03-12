<?php
class Database {
	private $host = "localhost";
	private $db_name = "database_name";
	private $username = "your_username";
	private $password = "password_of_your_database";
	public $conn;

	public function getConnection(){
		$this->conn = null;

		try{
			$this->conn = new PDO("mysql:host=" . $this->host . ";dbname=" . $this->db_name, $this->username, $this->password);
		}catch(PDOException $exception){
			echo "Erro de conecção: " . $exception->getMessage();
		}
		return $this->conn;
	}
	
}




?>