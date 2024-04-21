namespace v1.Customer.Exceptions;

public class CustomerNotFoundException(string ssn) : Exception($"Customer whose SSN is {ssn} does not exist.")
{
}
