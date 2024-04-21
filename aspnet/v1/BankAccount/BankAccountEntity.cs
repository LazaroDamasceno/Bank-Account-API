using System.ComponentModel.DataAnnotations;

namespace v1.BankAccount;

public class BankAccountEntity
{
    [Key]
    public Guid Id { get; set; } = Guid.NewGuid();
    public Guid Number { get; set; } = Guid.NewGuid();
    public double Balance { get; set; } = 0.0;
    public Guid CustomerId { get; set; }

    public void Deposit(double cash)
    {
        Balance += cash;
    }

    public void Withdrawn(double cash)
    {
        Balance -= cash;
    }
}
