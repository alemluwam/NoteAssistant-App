package edu.mum.cs544.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import edu.mum.cs544.domain.Section;
import edu.mum.cs544.service.SectionService;

public class StringToSection implements Converter<String, Section> {
	@Autowired
	private SectionService sectionService;
	public Section convert(String sectionId) {
		return sectionService.findOne(Long.parseLong(sectionId));
	};
}
