var gulp = require('gulp');

gulp.task('watch-folder', [ 'copy-folder' ], function() {
	var watcher = gulp.watch([ './src/**/*', './pom.xml' ], [ 'copy-folder' ]);
	watcher.on('change', function(event) {
		console.log('File ' + event.path + ' was ' + event.type);
	});
});

gulp.task('copy-folder', function() {
	gulp.src([ './src/**/*', './pom.xml' ], {
		base : './'
	}).pipe(gulp.dest('C:\\Users\\Student\\Desktop\\Public\\student1\\shop')).pipe(
			gulp.dest('C:\\Users\\Student\\Desktop\\Public\\student2\\shop')).pipe(
			gulp.dest('C:\\Users\\Student\\Desktop\\Public\\student3\\shop')).pipe(
			gulp.dest('C:\\Users\\Student\\Desktop\\Public\\student4\\shop')).pipe(
			gulp.dest('C:\\Users\\Student\\Desktop\\Public\\student5\\shop')).pipe(
			gulp.dest('C:\\Users\\Student\\Desktop\\Public\\student6\\shop')).pipe(
			gulp.dest('C:\\Users\\Student\\Desktop\\Public\\student7\\shop')).pipe(
			gulp.dest('C:\\Users\\Student\\Desktop\\Public\\student8\\shop')).pipe(
			gulp.dest('C:\\Users\\Student\\Desktop\\Public\\student9\\shop'));
});