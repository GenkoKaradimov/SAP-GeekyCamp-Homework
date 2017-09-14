using Microsoft.AspNetCore.Mvc;
using Phonebook.Entities;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace Phonebook.Controllers
{
	public class PhotoController : Controller
	{
		private readonly Context _context;

		public PhotoController(Context context)
		{
			_context = context;
		}

		[HttpGet]
		public FileResult Photo(int id, int key)
		{
			return null;
		}
	}
}
