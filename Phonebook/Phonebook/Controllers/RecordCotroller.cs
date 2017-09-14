using Microsoft.AspNetCore.Mvc;
using Phonebook.Entities;
using Phonebook.ViewModels.Record;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Phonebook.Controllers
{
	public class RecordCotroller : Controller
	{
		private readonly Context _context;

		public RecordCotroller(Context context)
		{
			_context = context;
		}

		public IActionResult Index()
		{
			var model = new IndexViewModel
			{
				Records = _context.Records.Select(x => new RecordViewModel
				{
					Id = x.Id,
					Phone = x.Phone,
					FirstName = x.FirstName,
					SecondName = x.SecondName,
					DateCreated = x.DateCreated,
					UserId = x.UserId
				}).ToList()
			};

			return View(model);
		}

		[HttpGet]
		public IActionResult Create()
		{
			return View();
		}

		[HttpPost]
		public IActionResult AddRecord(RecordViewModel model)
		{
			int userId = 5;//todo
			Record record = new Record()
			{
				Phone = model.Phone,
				FirstName = model.FirstName,
				SecondName = model.SecondName,
				DateCreated = DateTime.Now,
				UserId = userId
			};

			_context.Records.Add(record);
			_context.SaveChanges();

			return RedirectToAction("Index");
		}

		[HttpGet("{id}")]
		public IActionResult Update(int id)
		{
			var record = _context.Records.FirstOrDefault(x => x.Id == id);

			if (record == null)
				return RedirectToAction("Index");

			var model = new RecordViewModel()
			{
				Id = record.Id,
				Phone = record.Phone,
				FirstName = record.FirstName,
				SecondName = record.SecondName
			};

			return View(model);
		}

		[HttpPut]
		public IActionResult Update(RecordViewModel model)
		{
			var record = _context.Records.FirstOrDefault(x => x.Id == model.Id);

			if (record == null)
				return RedirectToAction("Index");

			record.Phone = model.Phone;
			record.FirstName = model.FirstName;
			record.SecondName = model.SecondName;

			_context.SaveChanges();

			return RedirectToAction("Index");
		}

		[HttpDelete]
		public IActionResult Delete(int id)
		{
			var record = _context.Records.FirstOrDefault(x => x.Id == id);

			if (record == null)
				return RedirectToAction("Index");

			_context.Records.Remove(record);
			_context.SaveChanges();

			return RedirectToAction("Index");
		}
	}
}
