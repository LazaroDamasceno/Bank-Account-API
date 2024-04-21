namespace v1.BankAccount.Exceptions;

public class BankAccountNotFoundException(Guid number) : Exception($"Bank account whose number is {number} was not found.")
{
}
