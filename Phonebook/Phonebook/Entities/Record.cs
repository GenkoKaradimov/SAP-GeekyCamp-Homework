using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Phonebook.Entities
{
	public class Record
	{
		public int Id { get; set; }

		public string Phone { get; set; }

		public string FirstName { get; set; }

		public string SecondName { get; set; }

		public DateTime DateCreated { get; set; }

		public int PhotoId { get; set; }

		public int UserId { get; set; }

		#region

		public Photo Photo { get; set; }

		public User User { get; set; }
		public string Name { get; internal set; }

		#endregion
	}
}
