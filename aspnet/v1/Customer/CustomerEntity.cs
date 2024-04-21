using System.ComponentModel.DataAnnotations;
using v1.Customer.DTOs;

namespace v1.Customer;

public class CustomerEntity 
{ 
    [Key]
    public Guid Id { get; set; } = Guid.NewGuid();
    public string FullName { get; set; } = string.Empty;
    public DateOnly BirthDate { get; set; }
    public string Ssn { get; set; } = string.Empty;
    public string Address { get; set; } = string.Empty;
    public string Email { get; set; } = string.Empty;
    public string Gender { get; set; } = string.Empty;

    public static CustomerEntity CreateInstance(RegisterCustomerDTO dto)
    {
        return new CustomerEntity()
        {
            FullName = dto.FullName,
            BirthDate = dto.BirthDate,
            Ssn = dto.Ssn,
            Address = dto.Address,
            Email = dto.Email,
            Gender = dto.Gender
        };
    }

    public void Update(UpdateCustomerDTO dto)
    {
        FullName = dto.FullName;
        BirthDate = dto.BirthDate;
        Address = dto.Address;
        Email = dto.Email;
        Gender = dto.Gender;
    }
}
