using System;

namespace Phonebook.ViewModels.Record
{
	public class RecordViewModel
	{
		public int Id { get; set; }

		public string Phone { get; set; }

		public string FirstName { get; set; }

		public string SecondName { get; set; }

		public DateTime DateCreated { get; set; }

		public int PhotoId { get; set; }

		public int UserId { get; set; }
	}
}
