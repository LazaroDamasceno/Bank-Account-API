using System.ComponentModel.DataAnnotations;

namespace v1.Customer.DTOs;

public record RegisterCustomerDTO(
    [Required]
    string FullName,

    [Required]
    DateOnly  BirthDate,

    [Required, StringLength(9)]
    string Ssn,

    [Required]
    string Address,

    [Required, EmailAddress]
    string Email,

    [Required, MinLength(1)]
    string Gender
)
{
}
