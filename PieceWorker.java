package problem_2;

public class PieceWorker extends Employee
{
	private double wage = 0.0; // wage per piece
	private double pieces = 0.0; // number of pieces produced

	public double getWage() 
	{
		return wage;
	}
	public void setWage(double wage) 
	{
		this.wage = wage;
	}

	public double getPieces() 
	{
		return pieces;
	}
	public void setPieces(double pieces) 
	{
		this.pieces = pieces;
	}
	
	
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, double pieces) 
	{
		super(firstName, lastName, socialSecurityNumber);
		this.wage = wage; 
		this.pieces = pieces; 
		
	}

	@Override
	public double earnings() 
	{
		return ( getWage() * getPieces() );
	}

}
