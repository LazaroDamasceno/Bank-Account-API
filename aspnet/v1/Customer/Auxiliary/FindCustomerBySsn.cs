using Microsoft.EntityFrameworkCore;
using v1.Customer.Exceptions;

namespace v1.Customer.Auxiliary;

public class FindCustomerBySsn(AppDbContext context)
{
    private readonly AppDbContext _context = context;

    public CustomerEntity FindBySsn(string ssn) 
    {
        return _context.Customers.FirstOrDefault(e => e.Ssn == ssn) ?? throw new CustomerNotFoundException(ssn);
    }
}
