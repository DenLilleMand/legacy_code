package tests.db;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.db.MysqlWrapper;

import org.junit.Test;

import entities.User;

public class MysqlWrapperTest {

	@Test
	public void test() {
		MysqlWrapper wrapper = MysqlWrapper.getInstance();
	}

}
