using System.ComponentModel.DataAnnotations;
using v1.BankAccount.Exceptions;
using v1.Customer;
using v1.Customer.Auxiliary;

namespace v1.BankAccount.Auxiliary;

public class FindBankAccountByCustomer(AppDbContext context, FindCustomerBySsn findCustomer)
{
    private AppDbContext _context = context;
    private FindCustomerBySsn _findCustomer = findCustomer;

    public BankAccountEntity FindByCustomer([Required, StringLength(128)] string bankAccountNumber, [Required, StringLength(9)] string ssn)
    {
        CustomerEntity customer = _findCustomer.FindBySsn(ssn);
        Guid number = Guid.Parse(bankAccountNumber);
        BankAccountEntity? bankAccountEntity = _context.BankAccounts.FirstOrDefault(e => e.Number == number) ?? throw new BankAccountNotFoundException(number);
        if (bankAccountEntity.CustomerId != customer.Id) throw new BankAccountOwnershipException(number, customer.Id);
        return bankAccountEntity;
    }
}
