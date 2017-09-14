using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Phonebook.ViewModels.Photo
{
	public class Photo
	{
		public int Id { get; set; }

		public byte[] Content { get; set; }

		public string PhotoType { get; set; }

		public int RecordId { get; set; }
	}
}
