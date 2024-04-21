namespace v1.BankAccount.Exceptions;

public class BankAccountOwnershipException(Guid number, Guid ssn) : Exception($"Bannk account whose number is {number} is not owned by the customer whose SSN is ${ssn}.")
{
}
