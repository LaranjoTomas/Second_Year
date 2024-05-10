fid = fopen("datav1Pedro.txt");
c = textscan(fid, '%f%f');
fclose(fid);

YR = cell2mat(c);

h = plot(YR(:,1:1),log(YR(:,2:2)), 'o');
set(h, 'MarkerFaceColor', get(h,'Color'));
title('AED Graph-Sol1-108799')
