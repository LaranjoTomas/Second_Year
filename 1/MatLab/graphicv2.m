fid = fopen("datav2Pedrinho.txt");
c = textscan(fid, '%f%f');
fclose(fid);

YR = cell2mat(c);

h = plot(YR(:,1:1),YR(:,2:2), 'o');
set(h, 'MarkerFaceColor', get(h,'Color'));
title('AED Graph-Sol2-107378')
