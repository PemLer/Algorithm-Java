import os

path_seed = '../src/main/java/com/elmer/leetcode/'

count = 0
pkg_path = {}
for root, pkgs, files in os.walk(path_seed):
    for pkg in pkgs:
        if (pkg.startswith('t')):
            pkg_path[os.path.join(root, pkg)] = pkg
    if root in pkg_path:
        print(pkg_path[root], len(files))
        count += len(files)
print('total:', count)
