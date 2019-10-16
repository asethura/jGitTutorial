package com.asethura.jGitTutorial;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class jGitExample {

	public static void main(String[] args) throws IOException, IllegalStateException, GitAPIException {
		Git git = Git.cloneRepository().setURI("https://github.com/asethura/liquibase.git")
				.setDirectory(new File("/users/aks37/github/liquibase")) // #1
				.call();
		String absoluteFilePath = "/users/aks37/github/liquibase/test.txt";
		File file = new File(absoluteFilePath);
		if (file.createNewFile()) {
			System.out.println(absoluteFilePath + " File Created");
		}
		git.add().addFilepattern("test.txt").call();

		git.commit().setMessage("Initial commit").call();

		git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider("username", "password")).call();
	}
}
