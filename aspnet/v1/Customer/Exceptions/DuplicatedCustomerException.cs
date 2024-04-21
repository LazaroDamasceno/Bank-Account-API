namespace v1.Customer.Exceptions;

public class DuplicatedCustomerException(string ssn) : Exception($"Customer whose SSN is {ssn} already exist.")
{
}
